class Order
  def initialize
    @sum = 0
  end

  def sum
    @sum
  end

  def add_line(description, amount)
    @sum += amount
  end
end
