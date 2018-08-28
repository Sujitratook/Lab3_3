import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    public void shouldCreateOXObjectCorrectly() {

        OX ox = new OX();

        assertEquals(" 012\n0---\n1---\n2---\n", ox.getTableString());
        assertEquals("X", ox.getCurrentPlayer());
        assertEquals(0, ox.getcountO());
        assertEquals(0, ox.getcountX());
        assertEquals(0, ox.getcountdraw());
    }

    @Test
    public void putAt0() {
        OX ox = new OX();
        ox.put(1, 1);
        assertEquals(" 012\n0---\n1-X-\n2---\n", ox.getTableString());
        ox.put(0, 0);
        assertEquals(" 012\n0X--\n1-X-\n2---\n", ox.getTableString());
        ox.put(2, 1);
        assertEquals(" 012\n0X--\n1-XX\n2---\n", ox.getTableString());

        ox.Switchplayer(); //O
        ox.put(0, 2);
        assertEquals(" 012\n0X--\n1-XX\n2O--\n", ox.getTableString());

        assertEquals(false, ox.put(0, 2));
        assertEquals(false, ox.put(3,0));

    }
    @Test
    public void putOver() {
        OX ox = new OX();
        assertFalse(ox.put(0, -1));
        assertFalse(ox.put(0, 3));
        assertFalse(ox.put(3, -1));
        assertFalse(ox.put(-1, 3));

    }
    @Test
    public void Switchplayer() {
        OX ox = new OX();
        ox.Switchplayer();
        assertEquals("O", ox.getCurrentPlayer());
        ox.Switchplayer();
        assertEquals("X", ox.getCurrentPlayer());

    }
    @Test
    public void getAtTwo() {
        OX ox = new OX();
        assertTrue(ox.put(1, 1));
        assertFalse(ox.put(1, 1));
    }

    @Test
    public void getOver() {
        OX ox = new OX();
        assertNull(null, ox.get(0, -1));
        assertNull(null, ox.get(0, 3));
        assertNull(null, ox.get(3, -1));
        assertNull(null, ox.get(-1, 3));

    }

    @Test
    public void getAt0() {
        OX ox = new OX();
        ox.put(1, 1);
        assertEquals(" 012\n0---" +
                                  "\n1-X-" +
                                  "\n2---" +
                                  "\n", ox.getTableString());
        assertEquals("X",ox.get(1,1));
    }

    @Test
    public void Checkwin1() {
        OX ox = new OX();
        ox.put(0, 0);
        ox.put(0, 1);
        ox.put(0, 2);
        assertEquals(" 012\n0X--\n1X--\n2X--\n", ox.getTableString());
        assertEquals(true, ox.Checkwin(0, 0));
        assertEquals(true, ox.Checkwin(0, 1));
        assertEquals(true, ox.Checkwin(0, 2));
    }

    @Test
    public void Checkwin2() {
        OX ox = new OX();
        ox.put(0, 0);
        ox.put(0, 1);

        assertEquals(" 012\n0X--" +
                                  "\n1X--" +
                                  "\n2---" +
                                  "\n", ox.getTableString());
        assertEquals(false, ox.Checkwin(0, 0));
        assertEquals(false, ox.Checkwin(0, 1));
    }
    @Test
    public void Checkwin3() {
        OX ox = new OX();
        ox.put(1, 0);
        ox.put(1, 1);
        ox.put(1, 2);
        assertEquals(" 012\n0-X-" +
                                  "\n1-X-" +
                                  "\n2-X-" +
                                  "\n", ox.getTableString());
        assertEquals(true, ox.Checkwin(1, 0));
        assertEquals(true, ox.Checkwin(1, 1));
        assertEquals(true, ox.Checkwin(1, 2));
    }
    @Test
    public void Checkwin4() {
        OX ox = new OX();
        ox.put(0, 0);
        ox.put(1, 0);
        ox.put(2, 0);
        assertEquals(" 012\n0XXX" +
                                  "\n1---" +
                                  "\n2---" +"\n", ox.getTableString());
        assertEquals(true, ox.Checkwin(0, 0));
        assertEquals(true, ox.Checkwin(1, 0));
        assertEquals(true, ox.Checkwin(2, 0));
    }
    @Test
    public void Checkwin5() {
        OX ox = new OX();
        ox.put(0, 0);
        ox.put(1, 0);
        assertEquals(" 012\n0XX-\n1---\n2---\n", ox.getTableString());
        assertEquals(false, ox.Checkwin(0, 0));
        assertEquals(false, ox.Checkwin(1, 0));

    }
    @Test
    public void Checkwin6() {
        OX ox = new OX();
        ox.put(0, 1);
        ox.put(1, 1);
        ox.put(2, 1);
        assertEquals(" 012\n0---" +
                                  "\n1XXX" +
                                  "\n2---" +"\n", ox.getTableString());
        assertEquals(true, ox.Checkwin(0, 1));
        assertEquals(true, ox.Checkwin(1, 1));
        assertEquals(true, ox.Checkwin(2, 1));
    }
    @Test
    public void Checkwin7() {
        OX ox = new OX();
        ox.put(0, 0);
        ox.put(1, 1);
        ox.put(2, 2);
        assertEquals(" 012\n0X--" +
                                  "\n1-X-" +
                                  "\n2--X" +"\n", ox.getTableString());
        assertEquals(true, ox.Checkwin(0, 0));
        assertEquals(true, ox.Checkwin(1, 1));
        assertEquals(true, ox.Checkwin(2, 2));
    }
    @Test
    public void Checkwin8() {
        OX ox = new OX();
        ox.put(0, 2);
        ox.put(1, 1);
        ox.put(2, 0);
        assertEquals(" 012\n0--X" +
                                  "\n1-X-" +
                                  "\n2X--" +"\n", ox.getTableString());
        assertEquals(true, ox.Checkwin(0, 2));
        assertEquals(true, ox.Checkwin(1, 1));
        assertEquals(true, ox.Checkwin(2, 0));
    }
    @Test
    public void Checkwin9() {
        OX ox = new OX();
        ox.put(1, 1);
        assertEquals(" 012\n0---" +
                                  "\n1-X-" +
                                  "\n2---" +"\n", ox.getTableString());
        assertEquals(false, ox.Checkwin(1, 1));

    }
    @Test
    public void reset() {
        OX ox = new OX();
        ox.put(0, 2);
        ox.put(1, 1);
        ox.put(2, 0);
        ox.reset();
        assertEquals(" 012\n0---\n1---\n2---\n",ox.getTableString());
        assertEquals("X",ox.getCurrentPlayer());
        assertEquals(0,ox.getTurncount());
    }
    @Test
    public void getTurn(){
        OX ox = new OX();
        assertEquals(0,ox.getTurncount());
        ox.put(0,0);
        assertEquals(1,ox.getTurncount());
    }
    @Test
    public void isDraw(){
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.isDraw());

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.isDraw());

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.isDraw());
    }
    @Test
    public void getAtscoreO(){
        OX ox = new OX();
        ox.Switchplayer();
        assertEquals(0,ox.getAtscoreO());
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals(1,ox.getAtscoreO());
    }
    @Test
    public void getAtscoreDraw(){
        OX ox = new OX();
        assertEquals(0,ox.getAtscoreDraw());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.isDraw());

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.isDraw());

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertEquals(0,ox.getAtscoreDraw());
    }


}