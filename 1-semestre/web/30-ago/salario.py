from math import cos

a = int(input("Ângulo a => "))
b = int(input("Ângulo b => "))

lado_a = cos(a) + cos(b)
lado_b = 2 * cos((1 / 2) * (a + b)) * cos((1 / 2) * (a - b))

print(f"lado a => {lado_a} = {lado_b} <= lado b")
