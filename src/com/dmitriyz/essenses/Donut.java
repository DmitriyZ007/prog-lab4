package com.dmitriyz.essenses;

import com.dmitriyz.essenses.Plutocrat;

public class Donut extends Plutocrat {
    public Donut(int mass) {
        super("Пончик", mass);
    }

    @Override
    public void sayHi() {
        System.out.println(getName() + ": Я люблю параболоиды, а ещё я " + getCircs());
    }

}
