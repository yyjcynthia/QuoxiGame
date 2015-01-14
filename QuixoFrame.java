package assign1;

import assign1.QuixoBoard.Direction;
import assign1.QuixoBoard.Face;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;

public class QuixoFrame extends JFrame {

    private QuixoBoard board;
    private JButton[][] cubeButtonGroup;
    private JButton[] directionButtonGroup;
    private JButton restartButton;
    private JButton exitButton;
    private int rowOfCubeChoosen;
    private int colOfCubeChoosen;

    public JTextArea textArea;
    public Direction direction;

    public QuixoFrame() {
        setSize(500, 500);
        setTitle("Quixo Game");
        setResizable(false);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        setLocation((width - 600) / 2, (height - 600) / 2);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        board = new QuixoBoard();
        createCubeButtonGroup();
        createDirectionButtonGroup();
        createRestartExitButtons();

        textArea = new JTextArea();
        textArea.setSize(350, 30);
        textArea.setLocation(120, 20);
        textArea.setVisible(false);
        add(textArea);

        setVisible(true);
    }

    private void createCubeButtonGroup() {
        cubeButtonGroup = new JButton[5][5];
        MyEventListener listener = new MyEventListener();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cubeButtonGroup[i][j] = new JButton();
                cubeButtonGroup[i][j].setName(i + "_" + j);
                cubeButtonGroup[i][j].setSize(60, 60);
                cubeButtonGroup[i][j].setLocation(160 + 60 * j, 70 + 60 * i);
                add(cubeButtonGroup[i][j]);
                cubeButtonGroup[i][j].addActionListener(listener);
            }
        }
    }

    private void createDirectionButtonGroup() {
        directionButtonGroup = new JButton[4];
        String name;

        for (int i = 0; i < 4; i++) {
            directionButtonGroup[i] = new JButton();
            directionButtonGroup[i].setSize(100, 60);
            directionButtonGroup[i].setLocation(30, 70 + 80 * i);

            if (i == 0) {
                name = "UP";
            } else if (i == 1) {
                name = "LEFT";
            } else if (i == 2) {
                name = "RIGHT";
            } else {
                name = "DOWN";
            }

            directionButtonGroup[i].setName(name);
            directionButtonGroup[i].setText(name);
            Font font = new Font("Courier", Font.BOLD, 16);
            directionButtonGroup[i].setFont(font);
            add(directionButtonGroup[i]);

            MyEventListener listener = new MyEventListener();
            directionButtonGroup[i].addActionListener(listener);
        }
    }

    private void createRestartExitButtons() {
        restartButton = new JButton("Restart");
        restartButton.setName("Restart");
        restartButton.setSize(80, 40);
        restartButton.setLocation(200, 400);
        add(restartButton);

        exitButton = new JButton("Exit");
        exitButton.setName("Exit");
        exitButton.setSize(80, 40);
        exitButton.setLocation(350, 400);
        add(exitButton);

        Font font = new Font("Courier", Font.BOLD, 13);
        restartButton.setFont(font);
        exitButton.setFont(font);

        MyEventListener listener = new MyEventListener();
        restartButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    class MyEventListener implements ActionListener {

        private void actionOfCubeButtonGroup(ActionEvent ae) {

            textArea.setVisible(false);
            JButton theButton = (JButton) ae.getSource();
            String name = theButton.getName();
            int row = Integer.parseInt("" + name.charAt(0));
            int col = Integer.parseInt("" + name.charAt(2));
            
            rowOfCubeChoosen = row;
            colOfCubeChoosen = col;

            if (errorMessageCubeChoose()) return;

            board.move(rowOfCubeChoosen, colOfCubeChoosen, direction);
            cubeButtonGroupUpdate();
            winCheck();
        }

        private boolean errorMessageCubeChoose() {
            if (!board.validatePositionOfACubeChoosen(rowOfCubeChoosen, colOfCubeChoosen)) {
                textArea.setText("You are not allowed to move an inner cube or "
                        +"an opponent's cube.\n Please choose another cube");
                textArea.setVisible(true);
                return true;
            }
            if (direction == null) {
                textArea.setText("Please choose the direction first, then "
                        + "choose a cube for moving");
                textArea.setVisible(true);
                return true;
            }
            if (!board.validateMove(rowOfCubeChoosen, colOfCubeChoosen, direction)) {
                textArea.setText("This direction is not applicable for the cube "
                        + "you chose.\n Please rechoose direction or cube");
                textArea.setVisible(true);
                return true;
            }
            return false;
        }

        private void actionValidationOfDirectionButtonGroup(String text) {
            textArea.setVisible(false);
            int button_number = 0;

            if (text != null) {
                switch (text) {
                    case "UP":
                        direction = Direction.UP;
                        button_number = 0;
                        break;
                        
                    case "LEFT":
                        direction = Direction.LEFT;
                        button_number = 1;
                        break;
                        
                    case "RIGHT":
                        direction = Direction.RIGHT;
                        button_number = 2;
                        break;
                        
                    case "DOWN":
                        direction = Direction.DOWN;
                        button_number = 3;
                        break;
                        
                    default:
                        break;
                }
            }

            for (int i = 0; i < 4; i++) 
                directionButtonGroup[i].setBackground(null);

            directionButtonGroup[button_number].setBackground(Color.GRAY);
        }

        private void actionOfRestartButton() {
            int reply = JOptionPane.showConfirmDialog(null, "Restart the game? ",
                    "Restart?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                dispose();
                main(null);
            }
        }

        private void actionOfExitButton() {
            int reply = JOptionPane.showConfirmDialog(null, "Really quit the game? ",
                    "Quit?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Frame frame[] = Frame.getFrames();
                frame[0].dispose();
                System.exit(0);
            }
        }

        private void cubeButtonGroupUpdate() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    String face;
                    if ((board.faceOf(i, j)) == Face.BLANK) {
                        face = "";
                    } else{
                        face = ((board.faceOf(i, j) == Face.X) ? "X" : "O");
                    }

                    cubeButtonGroup[i][j].setText(face);
                }
            }
        }

        private void winCheck() {
            Face win = board.GameWinCheck();
            String winSymbol;
            if (win == null || win == Face.BLANK) {
                return;
            } else if (win == Face.X) {
                winSymbol = "X";
            } else {
                winSymbol = "O";
            }

            String messageBody = "Congratulations! Player " + winSymbol
                    + " won! Would you like to play again?";
            String[] options = {"Play Again?", "Quit"};
            int selection = JOptionPane.showOptionDialog(null, messageBody,
                    "Congratulations", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (selection == JOptionPane.YES_OPTION) {
                actionOfRestartButton();
            } else {
                actionOfExitButton();
            }
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String buttonText = (String) ae.getActionCommand();

            if (buttonText.equals("X")
                    || buttonText.equals("O")
                    || buttonText.equals("")) {
                actionOfCubeButtonGroup(ae);
            } else if (buttonText.equals("UP") || buttonText.equals("LEFT")
                    || buttonText.equals("RIGHT") | buttonText.equals("DOWN")) {
                actionValidationOfDirectionButtonGroup(buttonText);
            } else if (buttonText.equals("Restart")) {
                actionOfRestartButton();
            } else {
                actionOfExitButton();
            }
        }
    }

    public static void main(String[] args) {
        QuixoFrame frame = new QuixoFrame();
    }
}
