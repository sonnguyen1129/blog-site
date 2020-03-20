/* eslint-disable */
export class UserDTO {
  public username?: string;
  public password?: string;
  public email?: string;

  constructor(init?: Partial<UserDTO>) {
    Object.assign(this, init);
  }
}
