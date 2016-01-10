package mr.curk.piface;

/**
 * Created by Mr.Curk@gmail.com on 7.1.2016.
 */
public class HouseSecurityLogic implements PiLogicInterface {
    private PiFaceModule piFaceModule;
    private State input_0;
    private State input_1;
    private State input_2;
    private State input_3;
    private State input_4;
    private State input_5;
    private State input_6;
    private State input_7;
    private State output_0;
    private State output_1;
    private State output_2;
    private State output_3;
    private State output_4;
    private State output_5;
    private State output_6;
    private State output_7;

    private boolean input_0_running;

    public HouseSecurityLogic(PiFaceModule piFaceModule) {
        this.piFaceModule = piFaceModule;
        input_0 = piFaceModule.getStatusInput(0);
        input_1 = piFaceModule.getStatusInput(1);
        input_2 = piFaceModule.getStatusInput(2);
        input_3 = piFaceModule.getStatusInput(3);
        input_4 = piFaceModule.getStatusInput(4);
        input_5 = piFaceModule.getStatusInput(5);
        input_6 = piFaceModule.getStatusInput(6);
        input_7 = piFaceModule.getStatusInput(7);
    }

    @Override
    public void setInput(int pin, State state) {
        switch (pin) {
            case 0:
                input_0 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 1:
                input_1 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 2:
                input_2 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 3:
                input_3 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 4:
                input_4 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 5:
                input_5 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 6:
                input_6 = (state == State.ON ? State.ON : State.OFF);
                break;
            case 7:
                input_7 = (state == State.ON ? State.ON : State.OFF);
                break;
            default:
                break;
        }
        logic();
    }

    private void logic() {
        if (input_0 == State.ON && input_3 == State.ON && !input_0_running) {
            input_0_running = true;
            piFaceModule.setCommand(PiCommand.OUTPUT_1_ON);
            piFaceModule.setCommand(PiCommand.OUTPUT_2_ON);
            piFaceModule.setCommand(PiCommand.OUTPUT_3_ON);
            piFaceModule.setCommand(PiCommand.OUTPUT_4_ON);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            piFaceModule.setCommand(PiCommand.OUTPUT_5_ON);
            piFaceModule.setCommand(PiCommand.OUTPUT_6_ON);
            piFaceModule.setCommand(PiCommand.OUTPUT_7_ON);
            input_0_running = false;
        }

        if (input_1 == State.ON) {
            piFaceModule.setCommand(PiCommand.OUTPUT_1_OFF);
            piFaceModule.setCommand(PiCommand.OUTPUT_2_OFF);
            piFaceModule.setCommand(PiCommand.OUTPUT_3_OFF);
            piFaceModule.setCommand(PiCommand.OUTPUT_4_OFF);
            piFaceModule.setCommand(PiCommand.OUTPUT_5_OFF);
            piFaceModule.setCommand(PiCommand.OUTPUT_6_OFF);
            piFaceModule.setCommand(PiCommand.OUTPUT_7_OFF);
        }
    }
}
