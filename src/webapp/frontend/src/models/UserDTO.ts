/* eslint-disable */
export class UserDTO {
  // public id?: string;
  public username?: string;
  public password?: string;
  public email?: string;
  // public role?: string;

  constructor(init?: Partial<UserDTO>) {
    Object.assign(this, init);
  }
}
