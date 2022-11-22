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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (orientation != direction1.orientation) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) orientation;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + orientation + '}';
    }
}
