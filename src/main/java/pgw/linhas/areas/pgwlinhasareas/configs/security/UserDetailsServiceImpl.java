package pgw.linhas.areas.pgwlinhasareas.configs.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.AcessoDTO;
import pgw.linhas.areas.pgwlinhasareas.enums.NomeRole;
import pgw.linhas.areas.pgwlinhasareas.models.Role;
import pgw.linhas.areas.pgwlinhasareas.models.Usuario;
import pgw.linhas.areas.pgwlinhasareas.repositories.RoleRepository;
import pgw.linhas.areas.pgwlinhasareas.repositories.UsuarioRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * Esse metodo nos garante que o usuario de acesso no banco de dados é unico
     * É deste ponto que a busca do usurio no banco é realizados, mas para tal é necessario injetar a interface Repository da entidade usuario
     */

    final UsuarioRepository usuarioRepository;
    final PasswordEncoder passwordEncoder;
    final RoleRepository roleRepository;
    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com este nome:" + username));
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }

    /**
     * Não podemos deixar de criar um ponto de injeção de dependencia dessa classe na classe principal de
     * spring security, que é a Websecurity, para permitir assim a persistencia no banco dos dados de acesso assim como
     * a recupera dos mesmos
     * */

    public UserDetails criarUsuario(AcessoDTO acessoDTO){
        Usuario usuario = new Usuario();
        Role role = new Role();

        usuario.setUsername(acessoDTO.getUsuario());
        usuario.setPassword(passwordEncoder.encode(acessoDTO.getSenha()));
        role.setNomeRole(NomeRole.ROLE_USER);
       usuario = usuarioRepository.save(usuario);

       //busca Roles
       // role = roleRepository.findByName(NomeRole.ROLE_USER);

      return usuario;
    }
}
