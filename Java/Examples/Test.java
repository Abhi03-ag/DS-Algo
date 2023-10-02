class A {
	public void funA() {
		class B {
			public void funB() {
				System.out.println("inside B");

				class local {
					public void funl() {
						System.out.println("inside Anonymous");
					}
				}
				local obj = new local();
				obj.funl();
			}
		}

		B obj1 = new B();
		obj1.funB();
	}
}

class Test {
	public static void main(String args[]) {
		A obj = new A();
		obj.funA();
	}

}