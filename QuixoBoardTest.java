package assign1;

import assign1.QuixoBoard.Direction;
import assign1.QuixoBoard.Face;
import junit.framework.TestCase;

public class QuixoBoardTest extends TestCase {

    QuixoBoard _board;

    @Override
    protected void setUp() {
        _board = new QuixoBoard();
    }

    public void testCanary() {
        assertTrue(true);
    }

    public void testMoveTopLeftBlankCubeRight() {
        assertTrue(_board.move(0, 0, Direction.RIGHT));
    }

    public void testCheckFaceAfterMovingTopLeftBlankCubeRight() {
        _board.move(0, 0, Direction.RIGHT);
        assertEquals(Face.X, _board.faceOf(0, 4));
        assertEquals(Face.BLANK, _board.faceOf(0, 0));
    }

    public void testMoveTopLeftBlankCubeDown() {
        assertTrue(_board.move(0, 0, Direction.DOWN));
    }

    public void testCheckFaceAfterMoveTopLeftBlankCubeDown() {
        _board.move(0, 0, Direction.DOWN);
        assertEquals(Face.X, _board.faceOf(4, 0));
        assertEquals(Face.BLANK, _board.faceOf(0, 0));
    }

    public void testMoveTopLeftBlankCubeUp() {
        assertFalse(_board.move(0, 0, Direction.UP));
    }

    public void testMoveTopLeftBlankCubeLeft() {
        assertFalse(_board.move(0, 0, Direction.LEFT));
    }

    public void testMoveDownRightBlankCubeLeft() {
        assertTrue(_board.move(4, 4, Direction.LEFT));
    }

    public void testCheckFaceAfterMovingDownRightBlankCubeLeft() {
        _board.move(4, 4, Direction.LEFT);
        assertEquals(Face.X, _board.faceOf(4, 0));
        assertEquals(Face.BLANK, _board.faceOf(4, 4));
    }

    public void testMoveDownRightBlankCubeUp() {
        assertTrue(_board.move(4, 4, Direction.UP));
    }

    public void testCheckFaceAfterMovingDownRightBlankCubeUp() {
        _board.move(4, 4, Direction.UP);
        assertEquals(Face.X, _board.faceOf(0, 4));
        assertEquals(Face.BLANK, _board.faceOf(4, 4));
    }

    public void testMoveDownRightBlankCubeDown() {
        assertFalse(_board.move(4, 4, Direction.DOWN));
    }

    public void testMoveDownRightBlankCubeRIGHT() {
        assertFalse(_board.move(4, 4, Direction.RIGHT));
    }

    public void testMoveTopCenterBlankCubeLeft() {
        assertTrue(_board.move(0, 2, Direction.LEFT));
    }

    public void testCheckFaceAfterMoveTopCenterBlankCubeLeft() {
        _board.move(0, 2, Direction.LEFT);
        assertEquals(Face.X, _board.faceOf(0, 0));
        assertEquals(Face.BLANK, _board.faceOf(0, 2));
    }

    public void testMoveTopCenterBlankCubeRight() {
        assertTrue(_board.move(0, 2, Direction.RIGHT));
    }

    public void testCheckFaceAfterMoveTopCenterBlankCubeRight() {
        _board.move(0, 2, Direction.RIGHT);
        assertEquals(Face.X, _board.faceOf(0, 4));
        assertEquals(Face.BLANK, _board.faceOf(0, 2));
    }

    public void testMoveTopCenterBlankCubeDown() {
        assertTrue(_board.move(0, 2, Direction.DOWN));
    }

    public void testCheckFaceAfterMoveTopCenterBlankCubeDown() {
        _board.move(0, 2, Direction.DOWN);
        assertEquals(Face.X, _board.faceOf(4, 2));
        assertEquals(Face.BLANK, _board.faceOf(0, 2));
    }

    public void testMoveTopCenterBlankCubeUp() {
        assertFalse(_board.move(0, 2, Direction.UP));
    }

    public void testMoveRightCenterBlankCubeLeft() {
        assertTrue(_board.move(2, 4, Direction.DOWN));
    }

    public void testCheckFaceAfterMoveRightCenterBlankCubeLeft() {
        _board.move(2, 4, Direction.DOWN);

        assertEquals(Face.X, _board.faceOf(4, 4));
        assertEquals(Face.BLANK, _board.faceOf(2, 4));
    }

    public void testMoveCenterBlankCubeUp() {
        assertFalse(_board.move(2, 2, Direction.UP));
    }

    public void testMoveCenterBlankCubeDown() {
        assertFalse(_board.move(2, 2, Direction.DOWN));
    }

    public void testMoveCenterBlankCubeLeft() {
        assertFalse(_board.move(2, 2, Direction.LEFT));
    }

    public void testMoveCenterBlankCubeRight() {
        assertFalse(_board.move(2, 2, Direction.RIGHT));
    }

    public void testMoveTopLeftBlankCubeRightTwoTimes() {
        assertTrue(_board.move(0, 0, Direction.RIGHT));
        assertTrue(_board.move(0, 0, Direction.RIGHT));
    }

    public void testCheckFaceAfterMovingTopLeftBlankCubeRightTwoTimes() {
        _board.move(0, 0, Direction.RIGHT);
        _board.move(0, 0, Direction.RIGHT);
        assertEquals(Face.O, _board.faceOf(0, 4));
        assertEquals(Face.X, _board.faceOf(0, 3));
        assertEquals(Face.BLANK, _board.faceOf(0, 0));
    }

    public void testMoveTopLeftBlankCubeDownTwoTimes() {
        assertTrue(_board.move(0, 0, Direction.DOWN));
        assertTrue(_board.move(0, 0, Direction.DOWN));
    }

    public void testCheckFaceAfterMovingTopLeftBlankCubeDownTwoTimes() {
        _board.move(0, 0, Direction.DOWN);
        _board.move(0, 0, Direction.DOWN);
        assertEquals(Face.O, _board.faceOf(4, 0));
        assertEquals(Face.X, _board.faceOf(3, 0));
        assertEquals(Face.BLANK, _board.faceOf(0, 0));
    }

    public void testMoveDownRightBlankCubeUpTwoTimes() {
        assertTrue(_board.move(4, 4, Direction.UP));
        assertTrue(_board.move(4, 4, Direction.UP));
    }

    public void testCheckFaceAfterMovingDownRightBlankCubeUpTwoTimes() {
        _board.move(4, 4, Direction.UP);
        _board.move(4, 4, Direction.UP);
        assertEquals(Face.O, _board.faceOf(0, 4));
        assertEquals(Face.X, _board.faceOf(1, 4));
        assertEquals(Face.BLANK, _board.faceOf(4, 4));
    }

    public void testMoveDownRightBlankCubeLeftTwoTimes() {
        assertTrue(_board.move(4, 4, Direction.LEFT));
        assertTrue(_board.move(4, 4, Direction.LEFT));
    }

    public void testCheckFaceAfterMovingDownRightBlankCubeLeftTwoTimes() {
        _board.move(4, 4, Direction.LEFT);
        _board.move(4, 4, Direction.LEFT);
        assertEquals(Face.O, _board.faceOf(4, 0));
        assertEquals(Face.X, _board.faceOf(4, 1));
        assertEquals(Face.BLANK, _board.faceOf(4, 4));
    }

    public void testSecondPlayerMoveXCube() {
        _board.move(0, 0, Direction.RIGHT);
        assertFalse(_board.move(0, 4, Direction.LEFT));
    }

    public void testCheckFaceAfterSecondPlayerMoveXCube() {
        _board.move(0, 0, Direction.RIGHT);
        _board.move(0, 4, Direction.LEFT);
        assertEquals(Face.X, _board.faceOf(0, 4));
        assertEquals(Face.BLANK, _board.faceOf(0, 0));
    }

    public void testWinGameByRowMatch() {

        _board.move(0, 0, Direction.RIGHT);
        _board.move(1, 0, Direction.RIGHT);
        _board.move(0, 0, Direction.RIGHT);
        _board.move(1, 0, Direction.RIGHT);
        _board.move(0, 0, Direction.RIGHT);
        _board.move(1, 0, Direction.RIGHT);
        _board.move(0, 0, Direction.RIGHT);
        _board.move(1, 0, Direction.RIGHT);
        _board.move(0, 0, Direction.RIGHT);

        assertEquals(Face.X, _board.GameWinCheck());
    }

    public void testWinGameByColumnMatch() {

        _board.move(0, 0, Direction.DOWN);
        _board.move(0, 1, Direction.DOWN);
        _board.move(0, 0, Direction.DOWN);
        _board.move(0, 1, Direction.DOWN);
        _board.move(0, 0, Direction.DOWN);
        _board.move(0, 1, Direction.DOWN);
        _board.move(0, 0, Direction.DOWN);
        _board.move(0, 1, Direction.DOWN);
        _board.move(0, 0, Direction.DOWN);

        assertEquals(Face.X, _board.GameWinCheck());
    }

    public void testWinGameByDiagonalMatchRight() {

        _board.move(0, 0, Direction.RIGHT);
        _board.move(0, 3, Direction.DOWN);
        _board.move(1, 0, Direction.RIGHT);
        _board.move(1, 0, Direction.RIGHT);
        _board.move(2, 0, Direction.RIGHT);
        _board.move(2, 0, Direction.RIGHT);
        _board.move(2, 0, Direction.RIGHT);
        _board.move(3, 0, Direction.RIGHT);
        _board.move(3, 0, Direction.RIGHT);
        _board.move(3, 0, Direction.RIGHT);
        _board.move(3, 0, Direction.RIGHT);
        _board.move(3, 0, Direction.RIGHT);
        _board.move(4, 4, Direction.LEFT);

        assertEquals(Face.X, _board.GameWinCheck());
    }

    public void testWinGameByDiagonalMatchLeft() {

        _board.move(0, 4, Direction.LEFT);
        _board.move(0, 3, Direction.DOWN);
        _board.move(1, 4, Direction.LEFT);
        _board.move(1, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);
        _board.move(3, 4, Direction.LEFT);
        _board.move(3, 4, Direction.LEFT);
        _board.move(3, 4, Direction.LEFT);
        _board.move(3, 4, Direction.LEFT);
        _board.move(3, 4, Direction.LEFT);
        _board.move(4, 0, Direction.RIGHT);

        assertEquals(Face.X, _board.GameWinCheck());
    }

    public void testWinGameNoWin() {
        _board.move(0, 4, Direction.LEFT);
        _board.move(0, 3, Direction.DOWN);
        _board.move(1, 4, Direction.LEFT);
        _board.move(1, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);

        assertEquals(Face.BLANK, _board.GameWinCheck());
    }

    public void testWinGameBothPlayersFiveInLine() {

        _board.move(2, 4, Direction.LEFT);
        _board.move(1, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);
        _board.move(1, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);
        _board.move(1, 4, Direction.LEFT);
        _board.move(2, 4, Direction.LEFT);
        _board.move(1, 4, Direction.LEFT);
        _board.move(4, 4, Direction.UP);
        _board.move(4, 4, Direction.UP);
        _board.move(4, 4, Direction.UP);

        assertEquals(Face.O, _board.GameWinCheck());
    }
}
