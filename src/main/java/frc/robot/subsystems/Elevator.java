package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
   TalonFx motor_one;
   TalonFX motor_two;

    //max speed is .05

public Elevator(){
    //lmk if these below are errors on the team computer too because 
    //it might just be my computer being difficult again
    motor_one; = new TalonFx(/*port*/);
    motor_two; = new TalonFx(/*port*/);  //side note (again ikr eyeroll) idk the ports but 
                                      //im pretty sure the ones we use are in the constants...

    motor_one.setPosition(0);
    motor_one.set(.02);         //you can change this value if its too slow
                                // i think...
    motor_one.setPosition(0);
    motor_two.set(.02);

//most of the stuff is encoder values i believe bc setPosition is 
//using rotations 
}
    //grab values from actual tests from riologs?
    double l4value = motor_one.getPositon();
    //assuming levels are equidistant
    public double l3val = .66*l4value;
    public double l2val = .33*l4value;
    public double l1val =  0.01;
    
    public void runMotors(double speed) {
        motor_one.set(speed);
        motor_two.set(-speed);
        
    }

//making seperate methods for each level so perchance i can set
//one button per each thing
//joystick thing was perchance too ambitious
    public void l4(){
        motor_one.setPositon(l4value);
        motor_two.setPosition(-l4value);
        //idk if this works for sure, if the 
        // motors work in opposite directions th
        // en do they do to the same positon but 
        // just like the opposite? idk. 
        //gemini said yes 🥹

    }

    public void l3(){
        motor_one.setPositon(l3value);
        motor_two.setPosition(-l3value);
    }
    
    public void l2(double l2value){
        motor_one.setPositon(l2value);
        motor_two.setPosition(-l2value);
    }


    //i believe zeroeing out the position after each preset might 
    //make these work and im scared to see what would happen
    //if you dont

    public void zeroout(){
        motor_one.setPosition(0);
        motor_one.setPosition(0);
    } //if this line has an error for you i genuinely dont know why 
    //girl bye this bracket is making me go insane
    //the class ISN'T supposed to end liek dawg ik
    //vscode make sense challenge go!t6y54rt
    

    //my attempt with the joysticks 🫩✌️
    //the rest is in robot container where all the controls are
    //just fry me already

    public void generalmove(velo){
        motor_one.setVotlage(velo);
    }
    //this error above is related to the one on line 77... 🫩
    //(insert speed gif) 

    //also gonna make an "afk" thing that applies constant voltage to perchance 
    //keep the elevator at the target position like how we did witht eh climber wow

    public void afk(){
        if(motor_one.getPositon() < )
    }

}