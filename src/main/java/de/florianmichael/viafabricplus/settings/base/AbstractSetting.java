/*
 * This file is part of ViaFabricPlus - https://github.com/FlorianMichael/ViaFabricPlus
 * Copyright (C) 2021-2023 FlorianMichael/EnZaXD and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.florianmichael.viafabricplus.settings.base;

import com.google.gson.JsonObject;
import de.florianmichael.viafabricplus.screen.base.MappedSlotEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableTextContent;

public abstract class AbstractSetting<T> {
    private final MutableText name;
    private final T defaultValue;

    public T value;

    public AbstractSetting(final SettingGroup parent, final MutableText name, final T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;

        this.value = defaultValue;

        parent.getSettings().add(this);
    }

    public abstract MappedSlotEntry makeSettingRenderer();

    public abstract void write(final JsonObject object);
    public abstract void read(final JsonObject object);

    public MutableText getName() {
        return name;
    }

    public String getTranslationKey() {
        return ((TranslatableTextContent) name.getContent()).getKey();
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
