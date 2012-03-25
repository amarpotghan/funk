package org.javafunk.funk;

import org.javafunk.funk.functors.Generator;
import org.javafunk.funk.generators.ConstantGenerator;
import org.javafunk.funk.generators.FiniteGenerator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.javafunk.funk.Generators.constantGenerator;
import static org.javafunk.funk.Literals.listWith;

public class GeneratorsTest {
    @Test
    public void shouldConstructAConstantGeneratorWithTheSpecifiedValue() throws Exception {
        // Given
        Generator<Integer> expectedGenerator = new ConstantGenerator<Integer>(67463);

        // When
        Generator<Integer> actualGenerator = constantGenerator(67463);

        // Then
        assertThat(actualGenerator, is(expectedGenerator));
    }

    @Test
    public void shouldConstructAFiniteGeneratorUsingTheSpecifiedIterable() throws Exception {
        // Given
        Generator<Integer> expectedGenerator = new FiniteGenerator<Integer>(listWith(1, 2, 3, 4));

        // When
        Generator<Integer> actualGenerator = Generators.finiteGenerator(listWith(1, 2, 3, 4));

        // Then
        assertThat(actualGenerator, is(expectedGenerator));
    }
}