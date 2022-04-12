package com.elysian.springbootexercise.tests;

import com.elysian.springbootexercise.model.Section;
import com.elysian.springbootexercise.repository.SectionRepository;
import com.elysian.springbootexercise.service.SectionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SectionTest {

	@Mock
	private SectionRepository sectionRepository; // the collaborator (sectionRepository) is mocked

	// the tested service; also called 'system under test' // SUT
	@InjectMocks
	private SectionService sectionService;

	@Test
	@DisplayName("Given there are available sections, when retrieving the sections then sections are retrieved correctly")
	void givenThereAreAvailableSections_whenRetrievingSections_thenSectionsAreRetrievedCorrectly() {
		// arrange, including mocking behavior setup    --> given
		final List<Section> sections = Arrays.asList(
				new Section(1, "Manusi"),
				new Section(2, "Ghete")
		);
		when(sectionRepository.getAllSections()).thenReturn(sections);

		final List<Section> allSections = sectionService.getAllSections();

		assertNotNull(allSections, "The sections are null");
		assertEquals(allSections.size(), sections.size(), "Not all the sections were returned");
		assertTrue(allSections.iterator().hasNext(), "There is just a single section");
		allSections.forEach(section -> {
			assertThat(section.getId(), not(0));
			assertThat("The name must not be null or empty", StringUtils.hasLength(section.getName()));
		});
	}

	@Test
	@DisplayName("Given there are available sections, when retrieving a section by ID then the section is retrieved")
	void givenThereAreAvailableSections_whenRetrievingASectionById_thenTheSectionIsCorrectlyRetrieved() {
		final int sectionId = 20;

		final Section section = mock(Section.class);
		final String mockedName = "mocked name";
		when(section.getName()).thenReturn(mockedName);
		when(section.getId()).thenReturn((int) sectionId);

		when(sectionRepository.getSectionById(sectionId)).thenReturn(section);

		final Section resulted = sectionService.getSectionById(sectionId);

		assertNotNull(resulted);
		assertThat(resulted.getName(), is(mockedName));
		assertThat(resulted.getId(), not(0));
		assertThat(resulted.getId(), is(sectionId));
	}
}
