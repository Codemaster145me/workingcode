package frc.robot.subsystems;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Servo;

public class Arm extends SubsystemBase{
    //private Servo servo;
    private final Servo servo = new Servo(1); 
    double volatage = 0;

    /* 
    private final Spark Arm = new Spark(3);
    private final Spark HandUpDown = new Spark(4);
    private final Spark HandRightLeft = new Spark(5);
    */

	public static final int A = 1;
	//public static final int B = 2;
	public static final int X = 3;
	//public static final int Y = 4;
    public int cnt = 0; 

    static public JoystickButton ArmInButton = new JoystickButton(RobotContainer.m_controller, A);
    static public JoystickButton ArmOutButton = new JoystickButton(RobotContainer.m_controller, X);
    
    /** Creates a new ExampleSubsystem. */
    public Arm() {
    }

    /**
     * Example command factory method.
     *
     * @return a command
     */
    public CommandBase exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a
     * digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }
    public void VoltageAmountAdd(){
        volatage += 1;
    }

    public void VoltageAmountSub(){
        volatage -= 1;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        boolean A_out = ArmOutButton.getAsBoolean();
        boolean A_in = ArmInButton.getAsBoolean();

        cnt += 1; 
        if(this.cnt % 100 == 0 ){
            System.out.println(Boolean.toString(A_out) + Boolean.toString(A_in)); 
        }

        if(A_out == true){
            System.out.println("AZ");
            // servo.setAngle(volatage);
            servo.set(1000);
            VoltageAmountAdd();
        }

        if(A_in == true){
            System.out.println("A"); 
            VoltageAmountSub();
            //servo.setAngle(-volatage);
            servo.set(1000);
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}