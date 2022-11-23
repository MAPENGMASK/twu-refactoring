package com.twu.refactoring.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Direction {

    private static final Map<Character, Character> turnLeftMap = new HashMap<>();
    private static final Map<Character, Character> turnRightMap = new HashMap<>();

    private final char orientation;

    static {
        turnRightMap.put('N', 'E');
        turnRightMap.put('S', 'W');
        turnRightMap.put('E', 'N');
        turnRightMap.put('W', 'S');

        turnLeftMap.put('N', 'W');
        turnLeftMap.put('S', 'E');
        turnLeftMap.put('E', 'N');
        turnLeftMap.put('W', 'S');
    }

    public Direction(char orientation) {
        this.orientation = orientation;
    }

    public Direction turnRight() {
        Character nextOrientation = dictionaryQuery(turnRightMap);
        return new Direction(nextOrientation);
    }

    public Direction turnLeft() {
        Character nextOrientation = dictionaryQuery(turnLeftMap);
        return new Direction(nextOrientation);
    }

    private Character dictionaryQuery(Map<Character, Character> dic) {
        Character nextOrientation = dic.get(this.orientation);
        if (Objects.isNull(nextOrientation)) {
            throw new IllegalArgumentException();
        }
        return nextOrientation;
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
