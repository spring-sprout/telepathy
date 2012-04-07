package quize.number03.keesun;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class CursorTest {

	@Test
	public void action(){
		Cursor cursor = new Cursor();
		cursor.entrance(Cursor.Action.W, null);

		Cell cell = cursor.getCell();
		assertThat(cell.getColumn(), is(0));
		assertThat(cell.getRow(), is(0));

		cursor.exit(Cursor.Action.W);
	}

}
