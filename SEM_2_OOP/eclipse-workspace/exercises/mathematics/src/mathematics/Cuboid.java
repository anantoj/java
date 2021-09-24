package mathematics;

public class Cuboid<T extends Number> {
	private T width;
	private T length;
	private T height;

	public Cuboid(T width, T length, T height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}
	
	public T getWidth() {
		return width;
	}

	public void setWidth(T width) {
		this.width = width;
	}

	public T getLength() {
		return length;
	}

	public void setLength(T length) {
		this.length = length;
	}

	public T getHeight() {
		return height;
	}

	public void setHeight(T height) {
		this.height = height;
	}
	
}
