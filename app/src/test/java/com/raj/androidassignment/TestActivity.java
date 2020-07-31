package com.raj.androidassignment;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestActivity {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Mock
    NewsModelTD mUser;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void chkTitle() {
        ArgumentCaptor<String> ac=ArgumentCaptor.forClass(String.class);
        when(mUser.getTitle()).thenReturn("About Canada");
        String mTitle=mUser.getTitle();
        String title=mUser.getTitle(mTitle);
        verify(mUser,times(1)).getTitle(ac.capture());
        List<String> mValue=ac.getAllValues();
        assertThat(mUser.getTitle(),is(mValue.get(0)));

    }


}
