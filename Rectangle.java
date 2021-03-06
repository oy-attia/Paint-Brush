package secondary.shapes;

import essential.shapes.Polygon;

@SuppressWarnings("serial")
public class Rectangle extends Polygon {
	
	// constructor
	public Rectangle() {
		setNumOfPointsToDraw(2);
		setPointsCounter(0);
		vertices = new int[2][4];
		vertices[0][0] = -1;
		vertices[1][0] = -1;
		vertices[0][1] = -1;
		vertices[1][1] = -1;
		vertices[0][2] = -1;
		vertices[1][2] = -1;
		vertices[0][3] = -1;
		vertices[1][3] = -1;
	}

	// constructor
	public Rectangle(int x[], int y[]) {
		setNumOfPointsToDraw(2);
		setPointsCounter(getNumOfPointsToDraw());
		vertices = new int[2][4];
		vertices[0][0] = x[0];
		vertices[1][0] = y[0];
		vertices[0][1] = x[1];
		vertices[1][1] = y[0];
		vertices[0][2] = x[1];
		vertices[1][2] = y[1];
		vertices[0][3] = x[0];
		vertices[1][3] = y[1];
	}
	
	// constructor
	public Rectangle(Rectangle p) {
		setVertices(p.getVertices());
		setFillColor(p.getFillColor());
		setLayoutColor(p.getLayoutColor());
	}

	public void drawNextPoint(int x, int y) {
		if (getPointsCounter() < getNumOfPointsToDraw()) {
			updatePointNo(getPointsCounter(), x, y);
			setPointsCounter(getPointsCounter() + 1);
		}
	}

	public void updateNextPoint(int x, int y) {
		if (getPointsCounter() != getNumOfPointsToDraw())
			updatePointNo(getPointsCounter(), x, y);
	}

	public void updatePointNo(int pointNo, int x, int y) {
		if (getPointsCounter() == 0){
			for (int i = 0; i < vertices[0].length; i++) {
				vertices[0][i] = x;
				vertices[1][i] = y;
			}
		} else {
			if (pointNo == 0)
				update(x, y, vertices[0][1], vertices[1][1]);
			else
				update(vertices[0][0], vertices[1][0], x, y);
		}
	}

	private void update(int x1, int y1, int x2, int y2) {
		vertices[0][0] = x1;
		vertices[1][0] = y1;
		vertices[0][1] = x2;
		vertices[1][1] = y1;
		vertices[0][2] = x2;
		vertices[1][2] = y2;
		vertices[0][3] = x1;
		vertices[1][3] = y2;
	}
}