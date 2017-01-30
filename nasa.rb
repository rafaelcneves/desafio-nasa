class Nasa
  MAX_X_POSITION = 4
  MAX_Y_POSITION = 4
  MIN_X_POSITION = 0
  MIN_Y_POSITION = 0

  attr_accessor :x, :y, :orientation

  class OutOfBoundsError < StandardError
    def message
      "Out of bounds"
    end
  end

  class InvalidMoveError < StandardError
    def message
      "Invalid move"
    end
  end

  def initialize(moves)
    @x = 0; @y = 0
    @orientation = 'N'
    @moves = moves
  end

  def print_position
    raise OutOfBoundsError unless self.valid_position?
    puts "(#{@x}, #{@y}, #{@orientation})"
  rescue OutOfBoundsError => e
    puts e.message
  end

  def valid_position?
    @y.between?(MIN_Y_POSITION, MAX_Y_POSITION) && @x.between?(MIN_X_POSITION, MAX_X_POSITION)
  end

  def execute
    @moves.each_char do |move|
      case move
      when 'M' then self.move
      when 'R' then self.turn_right
      when 'L' then self.turn_left
      else raise InvalidMoveError
      end
    end
  rescue InvalidMoveError => e
    puts e.message
  end

  def move
    case @orientation
    when 'N' then @y += 1
    when 'S' then @y -= 1
    when 'W' then @x -= 1
    when 'E' then @x += 1
    end
  end

  def turn_right
    case @orientation
    when 'N' then @orientation = 'E'
    when 'S' then @orientation = 'W'
    when 'W' then @orientation = 'N'
    when 'E' then @orientation = 'S'
    end
  end

  def turn_left
    case @orientation
    when 'N' then @orientation = 'W'
    when 'S' then @orientation = 'E'
    when 'W' then @orientation = 'S'
    when 'E' then @orientation = 'N'
    end
  end
end

nasa = Nasa.new('MMRMMRMM')
nasa.execute
nasa.print_position

#  N
# W E
#  S
