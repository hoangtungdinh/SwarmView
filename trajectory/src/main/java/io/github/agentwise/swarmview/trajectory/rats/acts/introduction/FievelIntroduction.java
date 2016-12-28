/** */
package io.github.agentwise.swarmview.trajectory.rats.acts.introduction;

import io.github.agentwise.swarmview.trajectory.applications.trajectory.geom.point.Point4D;
import io.github.agentwise.swarmview.trajectory.control.FiniteTrajectory4d;
import io.github.agentwise.swarmview.trajectory.control.dto.Pose;
import io.github.agentwise.swarmview.trajectory.swarmmovements.Particle;

/** @author tom */
public class FievelIntroduction {

  private Particle fievel;

  private static final double YAW = -StrictMath.PI / 2;

  public FievelIntroduction(Pose initialPose, Pose finalPose, double start) {
    fievel = new Particle(initialPose);
    if (start > 0) {
      fievel.hover(start);
    }
    fievel.moveTriangleToPoint(Point4D.create(5, 2, 3, YAW), 1, 1);
    fievel.moveTriangleToPoint(Point4D.create(2, 2.5, 3, YAW), 1, 1);
    fievel.moveTriangleToPoint(Point4D.create(5, 3, 3, YAW), 1, 1);
    fievel.moveTriangleToPoint(Point4D.create(2, 3, 3, YAW), 1, 1);
    fievel.moveTriangleToPoint(Point4D.create(3.5, 2.8, 3, YAW), 1, 1);
    fievel.moveTriangleToPoint(Point4D.create(2.0, 2.8, 3, YAW), 1, 1);
    fievel.moveTriangleToPoint(Point4D.from(finalPose), 1, 1);
  }

  public FiniteTrajectory4d getTrajectory() {
    return fievel.getTrajectory();
  }

  public static FiniteTrajectory4d createTrajectory(
      Pose initialPosition, Pose finalPosition, double start) {

    FievelIntroduction fievel = new FievelIntroduction(initialPosition, finalPosition, start);
    return fievel.getTrajectory();
  }
}
