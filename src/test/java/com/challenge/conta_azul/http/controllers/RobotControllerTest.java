package com.challenge.conta_azul.http.controllers;

import com.challenge.conta_azul.domain.services.MarsService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

// @RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RobotControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private MarsService marsService;

  @InjectMocks
  private RobotController robotController;

  @Test
  public void testMoveRobotSuccess() throws Exception {
    String commands = "MMRMMRMM";
    String expectedResponse = "(2, 0, S)";

    when(marsService.executeCommands(commands)).thenReturn(expectedResponse);

    mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/{commands}", commands)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
  }

  @Test
  public void testMoveRobotInvalidCommand() throws Exception {
    String commands = "AAA";
    String errorMessage = "Invalid command";

    when(marsService.executeCommands(commands)).thenThrow(new IllegalArgumentException(errorMessage));

    mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/{commands}", commands)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string(errorMessage));
  }

  @Test
  public void testMoveRobotInvalidMovement() throws Exception {
    String commands = "MMMMMMMMMM";
    String errorMessage = "Invalid movement";

    when(marsService.executeCommands(commands)).thenThrow(new IllegalArgumentException(errorMessage));

    mockMvc.perform(MockMvcRequestBuilders.post("/rest/mars/{commands}", commands)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string(errorMessage));
  }
}
