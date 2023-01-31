package com.info.valorantinfo.data.mapper

import com.google.common.truth.Truth.assertThat
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.weaponDtoList
import org.junit.Before
import org.junit.Test

internal class WeaponUiDataListMapperImplTest {

    private val mapper = WeaponUiDataListMapperImpl()

    private lateinit var uiElements: List<WeaponUiData>

    @Before
    fun setup() {
        uiElements = mapper.map(weaponDtoList)
    }

    @Test
    fun `when weaponDto mapped is id correct`() {
        assertThat(uiElements[0].id).isEqualTo(weaponDtoList[0].uuid)
    }

    @Test
    fun `when weaponDto mapped is imageUrl correct`() {
        assertThat(uiElements[0].imageUrl).isEqualTo(weaponDtoList[0].displayIcon)
    }

    @Test
    fun `when weaponDto mapped is name correct`() {
        assertThat(uiElements[0].name).isEqualTo(weaponDtoList[0].displayName)
    }

    @Test
    fun `when weaponDto mapped is category correct`() {
        assertThat(uiElements[0].category).isEqualTo(
            weaponDtoList[0].category?.replace(
                "EEquippableCategory::",
                ""
            )
        )
    }

    @Test
    fun `when weaponDto mapped is size of list the same`() {
        assertThat(uiElements.size).isEqualTo(weaponDtoList.size)
    }

    @Test
    fun `when input weaponDto null is result empty`() {
        val newUiElements = mapper.map(null)
        assert(newUiElements.isEmpty())
    }


}