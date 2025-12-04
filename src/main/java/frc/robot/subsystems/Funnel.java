package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Funnel extends SubsystemBase {

    Servo motor_one, motor_two;
    boolean on_off = false;

    public Funnel() {
        motor_one = new Servo(1);
        motor_two = new Servo(2);
    }

    public void setBoth(double angle, double secondAngle) {
        motor_one.setAngle(angle);
        motor_two.setAngle(secondAngle);
    }

    public void flip() {
        if (on_off) {
            motor_one.setAngle(180.0);
            motor_two.setAngle(0);
        } else {
            motor_one.setAngle(0);
            motor_two.setAngle(180.0);
        }
        on_off = !on_off;
    }
    
}