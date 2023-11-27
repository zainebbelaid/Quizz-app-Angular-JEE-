package com.quizz.controller;

import com.quizz.dto.ThemeDto;
import com.quizz.manager.ThemeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@CrossOrigin(origins = "*")
@Controller
public class ThemeController {

    @Autowired
    private ThemeManager themeManager;

    @PostMapping("/addTheme")
    public ThemeDto addTheme(@RequestBody ThemeDto theme) {
        return themeManager.addTheme(theme);
    }

    @GetMapping("/getThemes")
    public List<ThemeDto> getThemes() {
        return themeManager.getThemes();
    }
    @GetMapping("/getThemes/{idTheme}")
    public ThemeDto getTheme(@PathVariable Long idTheme) {
        return themeManager.getTheme(idTheme);
    }
}
