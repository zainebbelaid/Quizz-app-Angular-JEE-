package com.quizz.manager;

import com.quizz.dao.LevelDao;
import com.quizz.dao.ThemeDao;
import com.quizz.dto.LevelDto;
import com.quizz.model.Level;
import com.quizz.model.OrikaBeanMapper;
import com.quizz.model.Theme;
import com.quizz.servce.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LevelManagerImpl implements LevelManager {

	 @Autowired
    private LevelService levelService;
	 @Autowired
    private LevelDao levelDao;
	 @Autowired
    private OrikaBeanMapper orikaBeanMapper;
	 @Autowired
    private ThemeDao themeDao;

 

    @Override
    public LevelDto addLevel(LevelDto levelDto, Long idTheme) {
        Theme theme = themeDao.getOne(idTheme);
        Level level = orikaBeanMapper.map(levelDto, Level.class);
        return orikaBeanMapper.convertDTO(levelService.addLevel(level, theme), LevelDto.class);
    }

    @Override
    public List<LevelDto> getLevels(Long idTheme) {
        Theme theme = themeDao.getOne(idTheme);
        List<Level> levels = theme.getLevels();
        return orikaBeanMapper.convertListDTO(levels, LevelDto.class);
    }

    @Override
    public LevelDto getLevel(Long idTheme) {
        return orikaBeanMapper.convertDTO(levelDao.getOne(idTheme), LevelDto.class);
    }
}
