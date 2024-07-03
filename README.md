# Mars Robot Exploration

## Overview

The purpose of this particular project is to make a REST API so that a robot can explore the rectangular terrain of Mars. The robot can travel within a given grid of 5x5 and respond to a series of commands so that the vehicle can navigate and take the area under exploration. Basically, this project involves the proper use of Java in the implementation of these best practices and using the Spring Boot framework for building the API.

## Requirements

- The terrain is a 5x5 grid.

- The robot at the co-ordinate (0, 0, N) will be notified to start.

- Commands can be sent to the robot, and the final position will be returned.

- The robot cannot move outside the specified area.

- The state of the robot should not be persisted between requests.

## Commands

- `L`: Put the robot in the state of 90 degrees the left.

- `R`: Put the robot in the state of 90 degrees the right.

- `M`: Put the robot in the state of bearing one step away in the direction of its current eyes.

## Example

For instance, if the robot is spotted in a 0, 0, N position, the robot can be moved to the new position (0, 2, W) by entering the command sequence `MML`.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/BrunoSilva-Correia/mars-robot.git
   cd mars-robot
   ```

2. Build the project using Maven:

   ```sh
   mvn clean install
   ```

3. Run the application:

   ```sh
   mvn spring-boot:run
   ```

4. Run the tests:

   ```sh
   mvn test
   ```

## Contact

- **Email**: brunocorreiasf@gmail.com
- **Github**: https://github.com/BrunoSilva-Correia
