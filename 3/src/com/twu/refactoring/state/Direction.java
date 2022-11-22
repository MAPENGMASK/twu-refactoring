package com.twu.refactoring.state;

public class Direction {
    private final char orientation;

    public Direction(char orientation) {
        this.orientation = orientation;
    }

    public Direction turnRight() {
        switch (orientation) {
            case 'N':
                return new Direction('E');
            case 'S':
                return new Direction('W');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        switch (orientation) {
            case 'N':
                return new Direction('W');
            case 'S':
                return new Direction('E');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
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
