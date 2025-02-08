import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Return a custom login page if you want
    }

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        model.addAttribute("username", oauth2User.getAttribute("name"));
        return "home"; // Return a page showing the user info or homepage
    }
}
