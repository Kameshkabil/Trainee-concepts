package com.example.dtoslearning.testing;

import com.example.dtoslearning.model.Aliens;
import com.example.dtoslearning.repository.AlienRepository;
import com.example.dtoslearning.service.AlienServiceLayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AlienServiceLayerTest {
    @InjectMocks
    private AlienServiceLayer alienServiceLayer;

    @Mock
    private AlienRepository alienRepository;

   @Test
    public void getAllAliensTest(){
       when(alienRepository.findAll()).thenReturn(Arrays.asList(new Aliens(1,"Dhivakar","Green",21),
               new Aliens(2,"Santha","red",20),
               new Aliens(3,"kamesh","Blue",20)));

       List<Aliens> la = alienServiceLayer.getAllAliens();

       assertEquals(1,la.get(0).getAlienId());
       assertEquals(2,la.get(1).getAlienId());
       assertEquals(3,la.get(2).getAlienId());
   }
   /*
   *  private long alienId;
    private String alienName;
    private String alienColor;
    private int alienAge;*/
}
