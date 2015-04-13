import org.scalatest.{FlatSpec, Matchers}

class BoolsSpec extends FlatSpec with Matchers with Bools {

  "TrueType" should "equal to itself" in {
    implicitly[TrueType =:= TrueType]
    "implicitly[TrueType =:= FalseType]" shouldNot typeCheck
  }

  "TrueType#Not" should "equal to FalseType" in {
    implicitly[![TrueType] =:= FalseType]
    "implicitly[![TrueType] =:= TrueType]" shouldNot typeCheck
  }

  "FalseType" should "equal to itself" in {
    implicitly[FalseType =:= FalseType]
    "implicitly[FalseType =:= TrueType]" shouldNot typeCheck
  }

  "FalseType#Not" should "equal to TrueType" in {
    implicitly[![FalseType] =:= TrueType]
    "implicitly[![FalseType] =:= FalseType]" shouldNot typeCheck
  }

  "A && B" should "follow the logical conjunction truth table" in {
    implicitly[TrueType && TrueType =:= TrueType]
    implicitly[TrueType && FalseType =:= FalseType]
    implicitly[FalseType && FalseType =:= FalseType]
    implicitly[FalseType && TrueType =:= FalseType]
  }

  "A || B" should "follow the logical disjunction truth table" in {
    implicitly[TrueType || TrueType =:= TrueType]
    implicitly[TrueType || FalseType =:= TrueType]
    implicitly[FalseType || TrueType =:= TrueType]
    implicitly[FalseType || FalseType =:= FalseType]
  }

  "A ==> B" should "should follow logical implication truth table" in {
    implicitly[TrueType ==> TrueType =:= TrueType]
    implicitly[TrueType ==> FalseType =:= FalseType]
    implicitly[FalseType ==> TrueType =:= TrueType]
    implicitly[FalseType ==> FalseType =:= TrueType]
  }

  "A ⊕ B" should "should follow logical exclusive disjunction truth table" in {
    implicitly[TrueType ⊕ TrueType =:= FalseType]
    implicitly[TrueType ⊕ FalseType =:= TrueType]
    implicitly[FalseType ⊕ TrueType =:= TrueType]
    implicitly[FalseType ⊕ FalseType =:= FalseType]
  }


}
