package by.tms.springmarket66.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Simon Pirko on 13.10.23
 */

@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public String home() {
    return "index"; // TODO: Not working without ViewResolver configuration
  }
}
