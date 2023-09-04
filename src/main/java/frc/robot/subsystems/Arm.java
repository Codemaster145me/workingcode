package frc.robot.subsystems;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Arm extends SubsystemBase{
    /** Creates a new ExampleSubsystem. */
    public Arm() {
    }

    private final Spark Arm = new Spark(2);
    private final Spark HandUpDown = new Spark(3);
    private final Spark HandRightLeft = new Spark(4);

	public static final int A = 1;
	//public static final int B = 2;
	public static final int X = 3;
	//public static final int Y = 4;

    static public JoystickButton ArmInButton = new JoystickButton(RobotContainer.m_controller, A);
    static public JoystickButton ArmOutButton = new JoystickButton(RobotContainer.m_controller, X);

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

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        if(A_out == true){
            Arm.set(-1);
        }

        if(A_in == true){
            Arm.set(1);
        }
        
        Arm.set(0);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}