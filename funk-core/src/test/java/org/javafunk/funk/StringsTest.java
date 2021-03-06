/*
 * Copyright (C) 2011-Present Funk committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */
package org.javafunk.funk;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.javafunk.funk.Literals.collectionWith;
import static org.javafunk.funk.Strings.join;

public class StringsTest {
    @Test
    public void shouldJoinAllStringsInTheCollectionUsingTheSeparator() {
        // Given
        Collection<String> strings = collectionWith("First", "Second", "Third");
        String separator = ", ";

        // When
        String joinedStrings = join(strings, separator);

        // Then
        assertThat(joinedStrings, is("First, Second, Third"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowANullPointerExceptionIfIterablePassedToJoinWithSeparatorIsNull() throws Exception {
        // Given
        Iterable<String> input = null;
        String separator = ".";

        // When
        join(input, separator);

        // Then a NullPointerException is thrown
    }

    @Test
    public void shouldJoinAllStringsInTheCollectionWithNoSeparator() {
        // Given
        Collection<String> strings = collectionWith("He", "ll", "o");

        // When
        String joinedStrings = join(strings);

        // Then
        assertThat(joinedStrings, is("Hello"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowANullPointerExceptionIfIterablePassedToJoinIsNull() throws Exception {
        // Given
        Iterable<String> input = null;

        // When
        join(input);

        // Then a NullPointerException is thrown
    }

    @Test
    public void shouldJoinAllPassedStringWithNoSeparator() {
        // When
        String joinedStrings = join("Goo", "db", "ye");

        // Then
        assertThat(joinedStrings, is("Goodbye"));
    }

    @Test
    public void shouldRenderNullsAsEmptyStrings() throws Exception {
        // Given
        Collection<String> strings = collectionWith("He", null, "o");

        // When
        String joinedStrings = join(strings);

        // Then
        assertThat(joinedStrings, is("Heo"));
    }
}
