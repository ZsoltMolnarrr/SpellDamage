package net.spell_power.api.attributes;

import net.spell_power.api.MagicSchool;
import net.spell_power.internals.AttributeFamily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attributes {
    public static String CRITICAL_CHANCE = "critical_chance";
    public static String CRITICAL_DAMAGE = "critical_damage";
    public static String HASTE = "haste";
    public static final Map<MagicSchool, AttributeFamily> POWER;
    public static float PERCENT_ATTRIBUTE_BASELINE = 100F;

    public static final Map<String, AttributeFamily> all;
    static {
        all = new HashMap<>();
        POWER = new HashMap<>();
        for (MagicSchool school : MagicSchool.values()) {
            var family = new AttributeFamily(school);
            all.put(family.name, family);
            POWER.put(school, family);
        }
        List.of(CRITICAL_CHANCE, CRITICAL_DAMAGE, HASTE).forEach(name -> {
            var family = new AttributeFamily(name, PERCENT_ATTRIBUTE_BASELINE);
            all.put(family.name, family);
        });
    }
}
