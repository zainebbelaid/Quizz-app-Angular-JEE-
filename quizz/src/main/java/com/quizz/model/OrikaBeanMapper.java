package com.quizz.model;

import com.quizz.dto.LevelDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.MapperFactory;

import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.unenhance.HibernateUnenhanceStrategy;
import java.util.List;

//permet de détecté automatiquement nos beans personalisé
@Component
//Orika est un framework de mappage Java Bean qui copie récursivement les données d'un objet à un autre

//ConfigurableMapper permet de simplifie la réutilisation de mappage orika
public class OrikaBeanMapper extends ConfigurableMapper {
	
	//est utilisé pour configurer et générer les instances de mappeur 
    private MapperFactory factory;

    public OrikaBeanMapper() {
        super(false);
        init();
    }
    


  
    @Override
    //methode pour fournir une configurations à mappeur Factory de type MapperFactory 
    protected void configure(MapperFactory factory) {
        this.factory = factory;

        registerClassMap(Level.class, LevelDto.class);
        factory.classMap(Level.class, LevelDto.class).field("theme.name", "themeName").byDefault().register();
    }
    private void registerClassMap(Class a, Class b) {
        this.factory.classMap(a, b).mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

   
    /**
     * Register class map with fields to exclude
     *
     * @param a
     * @param b
     * @param excludeFields
     */
    private void registerClassMap(Class a, Class b, String... excludeFields) {
        ClassMapBuilder builder = this.factory.classMap(a, b);
        for (String excludeField : excludeFields) {
            builder.exclude(excludeField);
        }
        builder.mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.compilerStrategy(new JavassistCompilerStrategy());
        factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());
    }

    /**
     * User Orika to convert entity => DTO / DTO => entity
     *
     * @param from
     * @param toClass
     * @param <T>
     * @param <U>     return
     */
    public <T, U> T convertDTO(U from, Class<T> toClass) {

        if (from == null) {
            return null;
        }

        return map(from, toClass);
    }

    /**
     * User Orika to convert entity => DTO / DTO => entity
     *
     * @param from
     * @param toClass
     * @param <T>
     * @param <U>
     * @return
     */
    public <T, U> List<T> convertListDTO(Iterable<U> from, Class<T> toClass) {

        if (from == null) {
            return null;
        }

        return mapAsList(from, toClass);
    }

    public <T, U> Page<T> convertPageDTO(Page<U> from, Class<T> toClass) {

        if (from == null) {
            return null;
        }

        return from.map(entity -> factory.getMapperFacade().map(entity, toClass));
    }


}
