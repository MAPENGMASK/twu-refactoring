package com.twu.refactoring.state;

import java.util.Objects;

public enum OrientationEnum {
    NORTH('N'),
    SOUTH('S'),
    WEST('W'),
    EAST('E');

    private final Character orientation;

    OrientationEnum(char orientation) {
        this.orientation = orientation;
    }

    public Character getOrientation() {
        return orientation;
    }

    public static OrientationEnum getByOrientation(Character orientation) {
        for (OrientationEnum orientationEnum : OrientationEnum.values()) {
            if (Objects.equals(orientationEnum.getOrientation(), orientation)) {
                return orientationEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
