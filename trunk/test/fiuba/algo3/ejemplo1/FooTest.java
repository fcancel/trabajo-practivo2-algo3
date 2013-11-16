package fiuba.algo3.ejemplo1;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.modelo.Foo;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Foo", result);

	}

}
