trait Bools {

  sealed trait BoolType {
    type Not <: BoolType
    type Or[That <: BoolType] <: BoolType
  }

  sealed trait TrueType extends BoolType {
    override type Not = FalseType
    override type Or[That <: BoolType] = TrueType
  }

  sealed trait FalseType extends BoolType {
    override type Not = TrueType
    override type Or[That <: BoolType] = That

  }

  type ![A <: BoolType] = A#Not
  type ||[A <: BoolType, B <: BoolType] = A#Or[B]
  type &&[A <: BoolType, B <: BoolType] = (A#Not || B#Not)#Not
  type ==>[A <: BoolType, B <: BoolType] = ![A] || B
  type ⊕[A <: BoolType, B <: BoolType] = (A && ![B]) || (![A] && B)

}
