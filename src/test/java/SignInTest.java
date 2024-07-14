import io.qameta.allure.Owner;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.Assert;
import org.testng.annotations.Test;

import static testPackage.SimpleClass.sumOfTwo;


class SignInTest {

    @Test
    public void testCanSignIn(){
        int result  = sumOfTwo(1);
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void testCanSignIn2(){
        int result  = sumOfTwo(2);
        assertThat(result).isEqualTo(3);
    }
}