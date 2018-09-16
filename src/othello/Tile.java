package othello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile extends ImageView {
	private static Image EMPTY_TILE_IMG;
	private static Image POTENTIAL_TILE_IMG;
	private static Image WHITE_TILE_IMG;
	private static Image BLACK_TILE_IMG;

	static {
		try {
			EMPTY_TILE_IMG = new Image(new FileInputStream("resources/empty.png"));
			POTENTIAL_TILE_IMG = new Image(new FileInputStream("resources/potential.png"));
			WHITE_TILE_IMG = new Image(new FileInputStream("resources/white.png"));
			BLACK_TILE_IMG = new Image(new FileInputStream("resources/black.png"));
		} catch (FileNotFoundException e) {
			Logger.getGlobal().info(e.getMessage());
		}
	}

	private Optional<String> owner = Optional.empty();

	private Image img;
	private int col;
	private int row;

	public Tile(int col, int row) {
		this.col = col;
		this.row = row;

		setupImageView();
	}

	private void setupImageView() {
		updateImage();
		setCache(true);
	}

	private void updateImage() {
		if (owner.isPresent()) {

		} else {
			setImage(EMPTY_TILE_IMG);
		}
	}

	public void setOwner(String owner) {
		this.owner = Optional.of(owner);
	}

	public Optional<String> getOwner() {
		return owner;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int x) {
		this.col = x;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int y) {
		this.row = y;
	}

	@Override
	public String toString() {
		return "Tile - " + col + "," + row;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
