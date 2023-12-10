resource "aws_security_group" "thehome_sg" {
  name        = "thehome_sg"
  description = "thehome security group"
  vpc_id      = aws_vpc.the-home_vpc_1.id
  tags        = {
    "Name" = "thehome_sg"
  }
}

resource "aws_security_group_rule" "public_out" {
  type              = "egress"
  from_port         = 0
  to_port           = 0
  protocol          = "-1"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.thehome_sg.id
}

resource "aws_security_group_rule" "public_in_ssh" {
  type              = "ingress"
  from_port         = 22
  to_port           = 22
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.thehome_sg.id
}

resource "aws_key_pair" "thehome_key" {
  key_name   = "thehome_key"
  public_key = file("~/.ssh/id_rsa.pub")
}

resource "aws_security_group_rule" "public_in_http" {
  type              = "ingress"
  from_port         = 80
  to_port           = 80
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.thehome_sg.id
}