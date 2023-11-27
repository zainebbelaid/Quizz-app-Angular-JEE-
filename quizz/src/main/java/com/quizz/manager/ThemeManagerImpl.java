package com.quizz.manager;

import com.quizz.dao.ThemeDao;
import com.quizz.dto.ThemeDto;
import com.quizz.model.OrikaBeanMapper;
import com.quizz.model.Theme;
import com.quizz.servce.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ThemeManagerImpl implements ThemeManager {

	@Autowired
    private OrikaBeanMapper orikaBeanMapper;

	@Autowired
    private ThemeService themeService;

	@Autowired
    private ThemeDao themeDao;

    

    @Override
    public ThemeDto addTheme(ThemeDto themeDto) {
        Theme theme = orikaBeanMapper.map(themeDto, Theme.class);
        return orikaBeanMapper.convertDTO(themeService.addTheme(theme), ThemeDto.class);
    }

    @Override
    public List<ThemeDto> getThemes() {
        List<Theme> themes = themeDao.findAll();
        return orikaBeanMapper.convertListDTO(themes, ThemeDto.class);
    }

    @Override
    public ThemeDto getTheme(Long idTheme) {
        return orikaBeanMapper.convertDTO(themeDao.getOne(idTheme), ThemeDto.class);
    }
}
