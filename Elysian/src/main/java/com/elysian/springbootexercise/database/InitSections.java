package com.elysian.springbootexercise.database;

import com.elysian.springbootexercise.model.Section;

import java.util.HashSet;
import java.util.Set;

public final class InitSections {

	private static final Set<Section> sections;

	static {
		sections = setUpSections();
	}

	// ######################### SECTIONS ########################
	private static Set<Section> setUpSections() {
		Set<Section> sections = new HashSet<>();
		sections.add(new Section(1, "Casti", InitProducts.getHelmets()));
		sections.add(new Section(2, "Manusi", InitProducts.getGloves()));
		sections.add(new Section(3, "Pantaloni", InitProducts.getTrousers()));
		sections.add(new Section(4, "Bocanci", InitProducts.getBoots()));
		return sections;
	}

	public static Set<Section> getSections() {
		return sections;
	}
}
