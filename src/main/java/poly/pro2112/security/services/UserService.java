package poly.pro2112.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import poly.pro2112.entities.Nguoidung;
import poly.pro2112.repository.NguoidungRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    NguoidungRepository nguoidungRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nguoidung nguoidung = nguoidungRepository.findNguoidungByTaikhoan(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(nguoidung);
    }
}
