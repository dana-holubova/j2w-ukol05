package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
public class RegistraceController {

  @GetMapping("/")
  public ModelAndView formular() {
//    ModelAndView modelAndView = new ModelAndView("/formular");
//    modelAndView.addObject("form", new RegistraceForm());
//    return modelAndView;

//    zkrácený zápis
    return new ModelAndView("/formular").addObject("form",new RegistraceForm());
  }

  @PostMapping("/")
  public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {
// pokud jsou zde chyby
    if (bindingResult.hasErrors()) {
return "/formular";
    }

//    kontrola věku
    if (form.getVek() <= 9 || form.getVek() >= 15) {
      bindingResult.rejectValue("datumNarozeni", "", "Věk dítěte musí být " +
              "mezi 9 a 15 lety včetně.");
      return "/formular";
    }

//    kontrola, že jsou vybrané alespoň dva sporty
//    Hláška se mi ve formuláři nezobrazuje. Možná je to tím, že je to tím, že neví, k jakému poli (field) se má připojit,
//    když jsou tam checkboxy.
      if (form.getVybranySport().size() < 2) {
          bindingResult.rejectValue("vybranySport", "", "Musí být vybrány alespoň dva sporty");
          return "/formular";
      }

//    když je formulář v pořádku
return new ModelAndView("/objednano")
        .addObject("form", form);
  }

}
