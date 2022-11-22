package com.twu.refactoring.state;

public class Direction {
    private final char orientation;

    public Direction(char orientation) {
        this.orientation = orientation;
    }

    public Direction turnRight() {
        OrientationEnum sourceOrientationEnum = OrientationEnum.getByOrientation(orientation);
        OrientationEnum targetOrientationEnum = switch (sourceOrientationEnum) {
            case NORTH -> OrientationEnum.EAST;
            case SOUTH -> OrientationEnum.WEST;
            case EAST -> OrientationEnum.NORTH;
            case WEST -> OrientationEnum.SOUTH;
        };
        return new Direction(targetOrientationEnum.getOrientation());
    }

    public Direction turnLeft() {
        OrientationEnum orientationEnum = OrientationEnum.getByOrientation(orientation);
        OrientationEnum targetOrientationEnum = switch (orientationEnum) {
            case NORTH -> OrientationEnum.WEST;
            case SOUTH -> OrientationEnum.EAST;
            case EAST -> OrientationEnum.NORTH;
            case WEST -> OrientationEnum.SOUTH;
        };
        return new Direction(targetOrientationEnum.getOrientation());
    }

    public char getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Direction temp = (Direction) obj;

        return this.orientation == temp.getOrientation();
    }

    @Override
    public int hashCode() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "orientation=" + orientation +
                '}';
    }
}
