import pygame, random

pygame.font.init()
font = pygame.font.Font(pygame.font.get_default_font(), 18)

class NaveEspacial:
    def __init__(self, name, text_position=(0, 0), position=(0, 0)):
        self.name = name
        self.alive = True
        self.position = position
        self.direction = 'cima'
        self.speed = 5  # Velocidade inicial
        self.shield = 100  # Nível de escudo inicial
        self.energy = 100  # Energia inicial
        self.moving = False
        self.image = pygame.image.load('nave.png')
        self.image = pygame.transform.scale(self.image, (40, 40))
        self.image_directions = {
            "cima": pygame.transform.rotate(self.image, 0),
            "direita": pygame.transform.rotate(self.image, 270),
            "baixo": pygame.transform.rotate(self.image, 180),
            "esquerda": pygame.transform.rotate(self.image, 90),
        }
        self.imagerect = self.image.get_rect()
        self.text_position = text_position

    def move(self):
        if self.moving == 'cima':
            self.position = (self.position[0], self.position[1] - self.speed)
        elif self.moving == 'direita':
            self.position = (self.position[0] + self.speed, self.position[1])
        elif self.moving == 'baixo':
            self.position = (self.position[0], self.position[1] + self.speed)
        elif self.moving == 'esquerda':
            self.position = (self.position[0] - self.speed, self.position[1])

    def turn(self, direction):
        self.direction = direction.lower()

        # Implementação para girar a nave
        self.image = self.image_directions[direction.lower()]

        print(f"{self.name} virou para a {direction}.")

    def shoot(self, player):
        # Implementação para lançar um projétil
        if self.energy >= 10:
            self.energy -= 10  # Custo de energia para atirar
            player.hit(10)
            print(f"{self.name} lançou um projétil em {player.name}.")
            bullet = Bullet(self)
            bullets.append(bullet)
        else:
            print(f"{self.name} não tem energia suficiente para atirar.")
            return False

    def hit(self, damage):
        if not self.alive:
            return

        # Implementação para quando a nave é atingida
        self.shield -= damage
        if self.shield <= 0:
            self.shield = 0
            self.alive = False
            print(f"{self.name} foi destruída.")
        else:
            print(f"{self.name} foi atingida! Escudo restante: {self.shield}")

    def recharge(self):
        # Implementação para recarregar energia
        self.energy += 50
        print(f"{self.name} recarregou sua energia.")
        
    def draw(self, window):
        if window is not None:
            if self.alive:
                window.blit(self.image, self.position)
            text_surface = font.render(f'{self.name} - Vida: {self.shield} - Energia: {self.energy}', True, (0, 0, 0))
            screen.blit(text_surface, dest=self.text_position)

class Bullet:
    def __init__(self, owner):
        self.owner = owner
        self.speed = 5  # Velocidade do projétil
        self.image = pygame.image.load('bullet.png')
        self.image = pygame.transform.scale(self.image, (20, 20))
        self.image_directions = {
            "cima": pygame.transform.rotate(self.image, 0),
            "direita": pygame.transform.rotate(self.image, 270),
            "baixo": pygame.transform.rotate(self.image, 180),
            "esquerda": pygame.transform.rotate(self.image, 90),
        }
        self.imagerect = self.image.get_rect()
        self.direction = owner.direction
        self.image = self.image_directions[self.direction]
        self.position = owner.position

    def move(self):
        if self.direction == 'cima':
            self.position = (self.position[0], self.position[1] - self.speed)
        elif self.direction == 'direita':
            self.position = (self.position[0] + self.speed, self.position[1])
        elif self.direction == 'baixo':
            self.position = (self.position[0], self.position[1] + self.speed)
        elif self.direction == 'esquerda':
            self.position = (self.position[0] - self.speed, self.position[1])

    def draw(self, window):
        if window is not None:
            window.blit(self.image, self.position)

bullets = []

p1 = NaveEspacial(input("Insira o nome da nave do player 1: ") or "Player 1")
p2 = NaveEspacial(input("Insira o nome da nave do player 2: ") or "Player 2")

# pygame setup
pygame.init()
screen = pygame.display.set_mode((800, 600))
clock = pygame.time.Clock()
running = True
last_recharge = pygame.time.get_ticks()

p1.text_position= (screen.get_width() -350, 20)
p2.text_position= (20, 20)

p1.position = ((screen.get_width() // 2 * 1.5), screen.get_height() // 2)
p2.position = (20, screen.get_height() // 2)

while running:
    # poll for events
    # pygame.QUIT event means the user clicked X to close your window
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
            
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                p1.turn("esquerda")
                p1.moving = "esquerda"
            elif event.key == pygame.K_RIGHT:
                p1.turn("direita")
                p1.moving = "direita"
            elif event.key == pygame.K_UP:
                p1.turn("cima")
                p1.moving = "cima"
            elif event.key == pygame.K_DOWN:
                p1.turn("baixo")
                p1.moving = "baixo"
            elif event.key == pygame.K_w:
                p2.turn("cima")
                p2.moving = "cima"
            elif event.key == pygame.K_s:
                p2.turn("baixo")
                p2.moving = "baixo"
            elif event.key == pygame.K_a:
                p2.turn("esquerda")
                p2.moving = "esquerda"
            elif event.key == pygame.K_d:
                p2.turn("direita")
                p2.moving = "direita"
            elif event.key == pygame.K_RSHIFT:
                p1.shoot(p2)
            elif event.key == pygame.K_SPACE:
                p2.shoot(p1)

        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT:
                p1.moving = False
            elif event.key == pygame.K_RIGHT:
                p1.moving = False
            elif event.key == pygame.K_UP:
                p1.moving = False
            elif event.key == pygame.K_DOWN:
                p1.moving = False
            elif event.key == pygame.K_w:
                p2.moving = False
            elif event.key == pygame.K_s:
                p2.moving = False
            elif event.key == pygame.K_a:
                p2.moving = False
            elif event.key == pygame.K_d:
                p2.moving = False

    # give recharge for both
    current_time = pygame.time.get_ticks()
    if current_time - last_recharge >= 5000:
        player_to_recharge = random.choice([p1, p2])
        player_to_recharge.recharge()
        last_recharge = current_time

    p1.move()
    p2.move()

    for bullet in bullets:
        bullet.move()
        if (bullet.position[0] < 0 or
            bullet.position[0] > screen.get_width() or
            bullet.position[1] < 0 or
            bullet.position[1] > screen.get_height()):
            bullets.remove(bullet)

    # fill the screen with a color to wipe away anything from last frame
    screen.fill("purple")

    # RENDER YOUR GAME HERE
    for bullet in bullets:
        bullet.draw(screen)
    p1.draw(screen)
    p2.draw(screen)

    # flip() the display to put your work on screen
    pygame.display.flip()

    clock.tick(60)  # limits FPS to 60

pygame.quit()

