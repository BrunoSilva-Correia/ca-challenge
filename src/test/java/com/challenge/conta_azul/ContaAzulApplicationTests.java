package com.challenge.conta_azul;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.challenge.conta_azul.domain.repositories.GridRepositoryTest;
import com.challenge.conta_azul.domain.repositories.PositionRepositoryTest;
import com.challenge.conta_azul.domain.services.MarsServiceTest;
import com.challenge.conta_azul.http.controllers.RobotControllerTest;

@RunWith(Suite.class)
@SuiteClasses({
		GridRepositoryTest.class,
		PositionRepositoryTest.class,
		MarsServiceTest.class,
		RobotControllerTest.class,
})
public class ContaAzulApplicationTests {
}
