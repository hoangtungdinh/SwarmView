package io.github.agentwise.swarmview.trajectory.rats;

import io.github.agentwise.swarmview.trajectory.control.Act;
import io.github.agentwise.swarmview.trajectory.control.ActConfiguration;
import io.github.agentwise.swarmview.trajectory.control.Choreography;
import io.github.agentwise.swarmview.trajectory.control.ChoreographyView;
import io.github.agentwise.swarmview.trajectory.control.DroneName;
import io.github.agentwise.swarmview.trajectory.control.DronePositionConfiguration;
import io.github.agentwise.swarmview.trajectory.control.dto.Pose;
import io.github.agentwise.swarmview.trajectory.rats.acts.introduction.IntroductionAct;

import java.util.ArrayList;
import java.util.List;

/** @author Hoang Tung Dinh */
public final class OTIntroAct {
  public static final double YAW = -Math.PI / 2.0;
  private static ActConfiguration config;

  static {
    final List<DronePositionConfiguration> introPositions = new ArrayList<>();
    introPositions.add(
        DronePositionConfiguration.create(
            DroneName.Nerve, Pose.create(6.7, 5.0, 1.0, YAW), Pose.create(2.0, 0.0, 3.0, YAW)));
    introPositions.add(
        DronePositionConfiguration.create(
            DroneName.Romeo, Pose.create(0.0, 5.0, 1.0, YAW), Pose.create(6.0, 5.0, 1.0, YAW)));
    introPositions.add(
        DronePositionConfiguration.create(
            DroneName.Juliet, Pose.create(0.0, 3.55, 1.0, YAW), Pose.create(6.7, 5.0, 1.0, YAW)));
    introPositions.add(
        DronePositionConfiguration.create(
            DroneName.Fievel, Pose.create(0.0, 2.0, 1.0, YAW), Pose.create(3.5, 0.0, 1.5, YAW)));
    introPositions.add(
        DronePositionConfiguration.create(
            DroneName.Dumbo, Pose.create(6.7, 1.0, 1.0, YAW), Pose.create(4.0, 3.5, 2.5, YAW)));

    config = ActConfiguration.create("IntroAct", introPositions);
  }

  public static ChoreographyView createIntroChoreography() {
    final Act introAct = IntroductionAct.create(config);
    introAct.lockAndBuild();

    final Choreography choreo =
        Choreography.create(
            DroneName.Nerve, DroneName.Romeo, DroneName.Juliet, DroneName.Fievel, DroneName.Dumbo);
    choreo.addAct(introAct);
    return choreo;
  }
}
